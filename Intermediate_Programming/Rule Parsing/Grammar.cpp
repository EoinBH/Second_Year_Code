#include "Grammar.h"
#include "fstream"

Grammar::Grammar(){}

// open the file, get its lines one-by-one, feeding these to Rule constructor
// and using to build up rules member
Grammar::Grammar(string fname) {
  ifstream f;
  f.open(fname);
  string line;
  while(getline(f,line)) {
    Rule rule(line);
    rules.push_back(rule);
  }
  f.close();
}

// go thru rules using each members show method
void Grammar::show() {
    for (int i = 0; i < rules.size(); i++) {
        rules[i].show();
    }
}
