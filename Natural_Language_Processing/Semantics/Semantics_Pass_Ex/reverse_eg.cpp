#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int  main() {
    vector<string> t;
    t.push_back("a");
    t.push_back("b");
    cout << "Current Vector:\n";
    for (int i = 0; i < t.size(); i++) {
        cout << t[i] << "\n";
    }
  reverse(t.begin(), t.end());
  // take a look
  cout << endl;
  cout << "Reversed Vector:\n";
  for(int i = 0; i < t.size(); i++) {
    cout << t[i] << "\n";
  }
}
