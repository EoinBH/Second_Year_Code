/************* TranslationDictionary.cpp **********************/
#include <string>
#include <iostream>
#include <fstream>

#include "TranslationDictionary.h"

using namespace std;

Trans_Dict::Trans_Dict() {}

/* builds dictionary from file with translation pairs source/translation */
/* on single lines                                                       */
Trans_Dict::Trans_Dict(string file_name) {
  string line, translation, word;
  ifstream f;
  Transpair p;
  size_t trans_offset;


  f.open(file_name);
  if(f) {
    opened_ok = true;
  }
  else {
    opened_ok = false;
  }
    
  if(opened_ok) {

    while(f >> line) {
      trans_offset = line.find('/'); /* trans_offset is location of / */

      if(trans_offset == string::npos) {
    cout << "there was an entry with no /\n";
    continue;
      }
      else {
    word = line.substr(0,trans_offset); // up to /
    translation = line.substr(trans_offset+1); // after /
    // make transpair with word and translation
    p.french = word;
    p.english = translation;
    thewords.push_back(p); // add transpair to thewords
      }

    }
  }

}


/* looks up word in dictionary, returning true or false  */
/* setting 'trans' to contain the translation if found  */

bool Trans_Dict::lookup(string word, string& trans) {
  int i;
  for(i = 0; i < thewords.size(); i++) {
    if (thewords[i].french == word) {
      trans = thewords[i].english;
      return true;
    }
  }
  return false;
}

bool Trans_Dict::lookupReverse(string word, string& trans) {
  int i;
  for (i = 0; i < thewords.size(); i++) {
    if (thewords[i].english == word) {
      trans = thewords[i].french;
      return true;
    }
  }
  return false;
}

void Trans_Dict::update(string french, string english) {
    bool frenchExists = false;
    /* If french word already exists, update its english translation */
    for (int i = 0; i < thewords.size(); i++) {
      if (thewords[i].french == french) {
        frenchExists = true;
        thewords[i].english = english;
      }
    }
    /* Otherwise, create new space for word and equivalent translation */
    if (frenchExists == false) {
        Transpair p;
        p.french = french;
        p.english = english;
        thewords.push_back(p);
    }
}

void Trans_Dict::export_to_file(string filename) {
  ofstream f(filename, ios::app);
  for (int i = 0; i < thewords.size(); i++) {
    f << thewords[i].french << '/' << thewords[i].english << '\n';
  }
  f.close();
}
