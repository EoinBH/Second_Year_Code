#include <string>
#include <vector>
#include <iostream>
#include <fstream>

using namespace std;

void fancy_print(vector<string> r);

int main(int argc, char *argv[]) {

    char *fname;
    ifstream file;
    fname = argv[1];
    file.open(fname);

    string line;
    int nrules = 0;
    vector<string> rule;
    vector<vector<string>> the_rules;
    size_t i, start, len;
    string category;

    while(getline(file,line)) {
        i = line.find(" --> ");
        start = i + 5;
        len = i;
        category = line.substr(0, len);
        rule.push_back(category);
        
        while((i = line.find(",", start)) != string::npos) {
            len = i - start;
            category = line.substr(start, len);
            rule.push_back(category);
            start = i + 1;
        }

        category = line.substr(start);
        rule.push_back(category);
        the_rules.push_back(rule);
        nrules++;
        rule.clear();
    }
    
    for (int i = 0; i < the_rules.size(); i++) {
        fancy_print(the_rules[i]);
    }
    
    cout << "number of rules was " << nrules << endl;
    
    int number;
    bool end = false;
    while (!end) {
        cout << "Please enter a number or type 0 to terminate program: \n";
        cin >> number;
        if (number != 0) {
            for (int i = 0; i < the_rules.size(); i++) {
                if (the_rules[i].size() - 1 == number) {
                    fancy_print(the_rules[i]);
                }
            }
        }
        else {
            end = true;
        }
    }
}

void fancy_print(vector<string> r) {
    for (unsigned int i = 1; i < r.size(); i++) {
        if (r[i][0] == '[') {
            if (r[i].find(']') != string::npos) {
                size_t length = r[i].find(']') - 1;
                size_t pos = 1;
                string word = r[i].substr(pos, length);
                cout << "word(" << word << ")";
            }
        } else if (i == r.size() - 1) {
            cout << r[i];
        } else {
            cout << r[i] << ", ";
        }
    }
    cout << " --> " << r[0] << endl;
}
