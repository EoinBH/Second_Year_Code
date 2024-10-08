#############################################################################
# Makefile for building interface (also testers) to parser classes
# adapted from file produced by qmake in Interface dir
#############################################################################

####### Compiler, tools and options

PARSERDIR = /shared/teaching/CSLL/2CSLL3/CFG_Parsers
#PARSERDIR = /tmp/InsTrial


INTERFACEDIR = $(PARSERDIR)/Interface

CC            = gcc
CXX           = g++
DEFINES       = -DQT_DEPRECATED_WARNINGS -DQT_NO_DEBUG -DQT_WIDGETS_LIB -DQT_GUI_LIB -DQT_CORE_LIB
CFLAGS        = -pipe -O2 -Wall -W -D_REENTRANT -fPIC $(DEFINES)
CXXFLAGS      = -pipe -O2 -Wall -W -D_REENTRANT -fPIC $(DEFINES)

QTINCPATH     = -isystem /usr/include/x86_64-linux-gnu/qt5 -isystem /usr/include/x86_64-linux-gnu/qt5/QtWidgets -isystem /usr/include/x86_64-linux-gnu/qt5/QtGui -isystem /usr/include/x86_64-linux-gnu/qt5/QtCore -I/usr/lib/x86_64-linux-gnu/qt5/mkspecs/linux-g++

INCPATH       = -I$(PARSERDIR) -I$(INTERFACEDIR) -I$(INTERFACEDIR)/InterfaceBase -I.


LINK          = g++
LFLAGS        = -Wl,-O1
LIBS          = $(SUBLIBS) /usr/lib/x86_64-linux-gnu/libQt5Widgets.so /usr/lib/x86_64-linux-gnu/libQt5Gui.so /usr/lib/x86_64-linux-gnu/libQt5Core.so /usr/lib/x86_64-linux-gnu/libGL.so -lpthread   


####### Files

PARSEROBJECTS = $(PARSERDIR)/TDPARSE.o \
		$(PARSERDIR)/BUPARSE.o \
		$(PARSERDIR)/TDPARSE_BT.o \
		$(PARSERDIR)/BUPARSE_BT.o \
		$(PARSERDIR)/BT_ITEM.o \
		$(PARSERDIR)/TDPARSE_BT_TREE.o \
		$(PARSERDIR)/BUPARSE_BT_TREE.o \
		$(PARSERDIR)/CHART.o \
		$(PARSERDIR)/CHART_SLASH.o \
		$(PARSERDIR)/PDA.o \
		$(PARSERDIR)/rules.o \
		$(PARSERDIR)/trees.o

PARSERHEADERS = $(PARSERDIR)/TDPARSE.h \
		$(PARSERDIR)/BUPARSE.h \
		$(PARSERDIR)/TDPARSE_BT.h \
		$(PARSERDIR)/BUPARSE_BT.h \
		$(PARSERDIR)/BT_ITEM.h \
		$(PARSERDIR)/TDPARSE_BT_TREE.h \
		$(PARSERDIR)/BUPARSE_BT_TREE.h \
		$(PARSERDIR)/CHART.h \
		$(PARSERDIR)/CHART_SLASH.h \
		$(PARSERDIR)/PDA.h \
		$(PARSERDIR)/rules.h \
		$(PARSERDIR)/trees.h

INTERFACEOBJECTS = $(INTERFACEDIR)/main.o \
		$(INTERFACEDIR)/ParserDriver.o \
		$(INTERFACEDIR)/moc_ParserDriver.o


OBJECTS = $(PARSEROBJECTS) $(INTERFACEOBJECTS)


interface: $(OBJECTS)  
	$(LINK) $(LFLAGS) -o interface $(OBJECTS) $(LIBS)



td_tester.o: td_tester.cpp
	$(CXX) $(CXXFLAGS) -I$(PARSERDIR) -c td_tester.cpp

td_tester: td_tester.o $(PARSEROBJECTS)
	$(CXX) $(CXXFLAGS) td_tester.o $(PARSEROBJECTS) -o td_tester

bu_tester.o: bu_tester.cpp
	$(CXX) $(CXXFLAGS) -I$(PARSERDIR) -c bu_tester.cpp

bu_tester: bu_tester.o $(PARSEROBJECTS)
	$(CXX) $(CXXFLAGS) bu_tester.o $(PARSEROBJECTS) -o bu_tester


td_bt_tester.o: td_bt_tester.cpp
	$(CXX) $(CXXFLAGS) -I$(PARSERDIR) -c td_bt_tester.cpp

td_bt_tester: td_bt_tester.o $(PARSEROBJECTS)
	$(CXX) $(CXXFLAGS) td_bt_tester.o $(PARSEROBJECTS) -o td_bt_tester


bu_bt_tester.o: bu_bt_tester.cpp
	$(CXX) $(CXXFLAGS) -I$(PARSERDIR) -c bu_bt_tester.cpp

bu_bt_tester: bu_bt_tester.o $(PARSEROBJECTS)
	$(CXX) $(CXXFLAGS) bu_bt_tester.o $(PARSEROBJECTS) -o bu_bt_tester

chart_tester.o: chart_tester.cpp
	$(CXX) $(CXXFLAGS) -I$(PARSERDIR) -c chart_tester.cpp

chart_tester: chart_tester.o $(PARSEROBJECTS)
	$(CXX) $(CXXFLAGS) chart_tester.o $(PARSEROBJECTS) -o chart_tester

example_tester.o: example_tester.cpp
	$(CXX) $(CXXFLAGS) -I$(PARSERDIR) -c example_tester.cpp

example_tester: example_tester.o $(PARSEROBJECTS)
	$(CXX) $(CXXFLAGS) example_tester.o $(PARSEROBJECTS) -o example_tester

# simple_tester.o: simple_tester.cpp
# 	$(CXX) $(CXXFLAGS) -I$(PARSERDIR) -c simple_tester.cpp -o simple_tester.o

# simple_tester: simple_tester.o
# 	$(LINK) $(LFLAGS) -o simple_tester simple_tester.o $(PARSEROBJECTS)



####### Build rules for any self defined parser classes
## assumes source code in CURRENT directory
## builds object code in CURRENT directory
##
## to have your own version of a class such as TDPARSE you need to 
## do two things
## 
## [1] uncomment the relevant build rule below 
##
## [2] also change relevant line in definition of PARSEROBJECTS above
## changing the 
## 
##    $(PARSERDIR)/TDPARSE.o \
##
## part of the def of PARSEROBJECTS to be just
##
##    TDPARSE.o \
##
##########################################################

#TDPARSE.o: TDPARSE.cpp $(PARSERHEADERS) 
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o TDPARSE.o TDPARSE.cpp

#BUPARSE.o: BUPARSE.cpp $(PARSERHEADERS)
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o BUPARSE.o BUPARSE.cpp

#TDPARSE_BT.o: TDPARSE_BT.cpp $(PARSERHEADERS)
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o TDPARSE_BT.o TDPARSE_BT.cpp

#BUPARSE_BT.o: BUPARSE_BT.cpp $(PARSERHEADERS) 
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o BUPARSE_BT.o BUPARSE_BT.cpp

#BT_ITEM.o: BT_ITEM.cpp $(PARSERHEADERS) 
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o BT_ITEM.o BT_ITEM.cpp

#TDPARSE_BT_TREE.o: TDPARSE_BT_TREE.cpp $(PARSERHEADERS)
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o TDPARSE_BT_TREE.o TDPARSE_BT_TREE.cpp

#BUPARSE_BT_TREE.o: BUPARSE_BT_TREE.cpp $(PARSERHEADERS)
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o BUPARSE_BT_TREE.o BUPARSE_BT_TREE.cpp

#CHART.o: CHART.cpp $(PARSERHEADERS) 
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o CHART.o CHART.cpp

#CHART_SLASH.o: CHART_SLASH.cpp $(PARSERHEADERS) 
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o CHART_SLASH.o CHART_SLASH.cpp

#PDA.o: PDA.cpp $(PARSERHEADERS)
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o PDA.o PDA.cpp

#rules.o: rules.cpp $(PARSERHEADERS)
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o rules.o rules.cpp

#trees.o: trees.cpp $(PARSERHEADERS)
#	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o trees.o trees.cpp











