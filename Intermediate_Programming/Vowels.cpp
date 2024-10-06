#include <string>
#include <iostream>
using namespace std;

int isVowel(char c) {
  switch(c) {
  case ('a'):
    return true;
  case ('e'):
    return true;
  case ('i'):
    return true;
  case ('o'):
    return true;
  case ('u'):
    return true;
  default:
    return false;
  }
}
int main() {

  string s;
  cout << "Enter a word\n";
  cin >> s;
  for(int i=0; i < s.size(); i++) {
    char c;
    c = s[i];
    if (isVowel(c)) {
      cout << c << ": " << "V" << endl;
    }
    else {
      cout << c << ": " << "C" << endl;
    }
  }
}
