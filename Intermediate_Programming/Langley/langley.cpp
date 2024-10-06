#include <string>
#include <vector>
#include <iostream>
#include <fstream>
using namespace std;

bool is_an_email(string s);

int main() {

  string filename;
  cout << "which file\n";
  cin >> filename;
  
  ifstream f;
  f.open(filename);
  if(!f) {
      cout << "could not open\n";
      return 0;
  }
    
    vector<string> strings;
    string line, next;
    size_t x, start, length;
    
    while(getline(f, line)) {
        start = 0;
        while((x = line.find(' ', start)) != string::npos) {
            length = x-start;
            next = line.substr(start, length);
            strings.push_back(next);
            start = x + 1;
        }
         next = line.substr(start);
         strings.push_back(next);
    }
    
    for(int i = 0; i < strings.size(); i++) {
      if(is_an_email(strings[i])) {
          cout << strings[i] << "\n";
      }
    }
}

bool is_an_email(string s) {
    if (s[0] == '@' || s[s.size() - 1] == '@') {
        return false;
    }
    else if (s.find('@') != string::npos) {
        return true;
    }
    else {
        return false;
    }
}
