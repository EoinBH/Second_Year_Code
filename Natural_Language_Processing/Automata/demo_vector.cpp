#include <fstream>
#include <iostream>
#include <vector>
#include <string>
#include "../FSA.h"
#include <map>

using namespace std;

int main(int argc, char *argv[]) {

  /******************************/
  /* build vector from old list */
  /******************************/
  //string old_name = "pre_t_words_10k";
  string old_name = string(argv[1]); // "pre_t_words_10k";
  string new_name = string(argv[2]); // "post_t_words_10k";
  
  ifstream old_f;
  old_f.open(old_name);

  if(!old_f) {
    cout << "prob opening " << old_name << endl;
    return 1;
  }

  vector<string> vec;
  
  int num_lines = 0;
  string word;
  
  while(old_f >> word) {
    num_lines++;
    vec.push_back(word);
  }
  
  cout << "num lines was: " << num_lines << endl;
  old_f.close();
  
  /*************************************/
  /* read new and check if also in old */
  /*************************************/

  ifstream new_f;
  new_f.open(new_name);

  if(!new_f) {
    cout << "prob opening " << new_name << endl;
    return 1;
  }

  int new_words = 0;
  while(new_f >> word) {
    bool found = false;
    for(size_t i = 0; i < vec.size(); i++) {
      if(vec[i] == word) {
	found = true;
	break;
      }
    }
    
    if(found == false) {
      new_words++;
    }
  }
  
  cout << "new words: " << new_words << endl;

  
}
