/*********************************/
/* tests the Trans_Dict class    */
/*********************************/
#include <iostream>
#include "TranslationDictionary.h"
#include <stdlib.h>

using namespace std;

void tester_function(Trans_Dict& d, string name, vector<string> fr_words, bool reverse);


int main() {
    Trans_Dict d1("translist");
    Trans_Dict d2("translist2");

    if(!d1.opened_ok) {
      cerr << "dictionary to translist did not open ok\n";
      exit(0);
    }

    if(!d2.opened_ok) {
      cerr << "dictionary to translist2 did not open ok\n";
      exit(0);
    }
    /* you could replace the above series of tests with the following
       more economical code which use a function to run the tests

     */
     vector<string> fr_words;
     fr_words.push_back("maison");
     fr_words.push_back("chien");
     fr_words.push_back("garcon");
     tester_function(d1, "translist", fr_words, false);

     fr_words.clear();
     fr_words.push_back("garcon");
     fr_words.push_back("sante");
     fr_words.push_back("maison");
     tester_function(d2, "translist2", fr_words, false);
    
     fr_words.clear();
     fr_words.push_back("house");
     fr_words.push_back("hat");
     fr_words.push_back("dog");
     tester_function(d1, "translist", fr_words, true);
    
     d2.update("sante","cheers");
     cout << "updated translation of sante in d2 \n";
     d2.update("chapeau","hat");
     cout << "added translation of chapeau in d2 \n";
     fr_words.clear();
     fr_words.push_back("chapeau");
     fr_words.push_back("sante");
     fr_words.push_back("garcon");
     tester_function(d2, "translist2", fr_words, false);
    
     d1.export_to_file("dictionaryContents");
     d2.export_to_file("dictionaryContents");
}

void tester_function(Trans_Dict& d, string name, vector<string> fr_words, bool reverse) {
  string trans;
  for(unsigned int i=0; i < fr_words.size(); i++) {
    if (reverse) {
      if(d.lookupReverse(fr_words[i], trans)) {
        cout << name << " trans of " << fr_words[i] << " is " << trans << endl;
      }
      else {
        cout << "no " << name << " trans of " << fr_words[i] << endl;
      }
    }
    else {
      if(d.lookup(fr_words[i], trans)) {
        cout << name << " trans of " << fr_words[i] << " is " << trans << endl;
      }
      else {
        cout << "no " << name << " trans of " << fr_words[i] << endl;
      }
    }
  }
  cout << "------------\n";
}
