#include <string>
#include <vector>

using namespace std;

class Rule {
 public:
  Rule();
  Rule(string input);
  string rule_as_string;
  string mother;
  vector<string> daughters;
  void show();

};
