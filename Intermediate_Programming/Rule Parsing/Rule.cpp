#include "Rule.h"
#include <iostream>

Rule::Rule() {}

// make the rule_as_string member be same as 'input'
Rule::Rule(string input) {
  rule_as_string = input;
  size_t i, start, len;
  string daughter;

  i = rule_as_string.find(" --> ");
  start = i + 5;
  len = i;
  mother = rule_as_string.substr(0, len);
        
  while((i = rule_as_string.find(",", start)) != string::npos) {
    len = i - start;
    daughter = rule_as_string.substr(start, len);
    daughters.push_back(daughter);
    start = i + 1;
  }
  daughter = rule_as_string.substr(start);
  daughters.push_back(daughter);
}

// show the the rule_as_string member
void Rule::show() {
  cout << mother << " --> ";
  for (int i = 0; i < daughters.size(); i++) {
    if (i != (daughters.size() - 1)) {
      cout << daughters[i] << ',';
    }
    else {
      cout << daughters[i] << endl;
    }
  }
  /* Sample way in which number of daughters could easily be accessed: */
  //cout << "number of daughters in this rule: " << daughters.size() << endl;
}
