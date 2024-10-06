#include <string>
#include <iostream>
#include <fstream>
using namespace std;

bool is_vowel(char c);
bool is_cons(char c);

int main() {
  ifstream thefile;
  thefile.open("afile_from_bodmer.txt");

  cout << "elim which?: enter 1 for vowels or 2 for cons\n";
  int choice;
  cin >> choice;

  string s;
  while(getline(thefile,s)) {
      for (int i = 0; i < s.length(); i++) {
          char c = s[i];
          if (choice == 1) {
              if (is_cons(c)) {
                  cout << c;
              }
              else {
                  if (is_vowel(c)) {
                      cout << "*";
                  }
                  else {
                      cout << " ";
                  }
              }
          }
          else {
              if (is_cons(c)) {
                  cout << "*";
              }
              else {
                  if (is_vowel(c)) {
                      cout << c;
                  }
                  else {
                      cout << " ";
                  }
              }
          }
      }
      cout << "\n";
  }

}
