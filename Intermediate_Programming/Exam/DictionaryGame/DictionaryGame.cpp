#include <string>
#include <iostream>
#include <fstream>
#include <vector>
using namespace std;

class DictionaryGame {
public:
    DictionaryGame(string fname);
    void run_game(string source, string target);
    string generate_words(string& source);
private:
    vector<string> dictionary;
};

DictionaryGame::DictionaryGame(string fname) {
    string line = "";
    ifstream f;
    f.open(fname);
    if(f) {
        while(f >> line) {
            dictionary.push_back(line);
        }
    }
    else {
        cout << "Failed to open file" << "\n";
    }
}

void DictionaryGame::run_game(string source, string target) {
    string current_word = source;
    bool game_ended = false;
    int position;
    char letter;
    string action;
    cout << "source word is: " << source << "\n";
    cout << "target word is: " << target << "\n";
    while (!game_ended) {
        cout << "now word is: " << current_word << "\n";
        cout << "position and letter? ";
        cin >> action;
        bool is_word = false;
        string tmp_word = "";
        if (action == "del") {
            cin >> position;
            for (int i = 0; i < current_word.length(); i++) {
                if (i == position) {
                    continue;
                }
                tmp_word += string(1, current_word[i]);
            }
        }
        else if (action == "ins") {
            cin >> position >> letter;
            bool inserted = false;
            for (int i = 0; i < current_word.length(); i++) {
                if (!(inserted)) {
                    if (i == position) {
                        tmp_word += string(1, letter);
                        inserted = true;
                        i--;
                        continue;
                    }
                }
                tmp_word += string(1, current_word[i]);
            }
        }
        else if (action == "swap") {
            cin >> position >> letter;
            tmp_word = current_word;
            tmp_word[position] = letter;
        }
        else if (action == "end") {
            game_ended = true;
        }
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary[i] == tmp_word) {
                current_word = tmp_word;
                is_word = true;
                break;
            }
        }
        if (!(is_word) && !(game_ended)) {
            cout << tmp_word << " is not a word.\n";
        }
        if (current_word == target) {
            cout << "Congratulations! You reached " << target << "\n";
            game_ended = true;
        }
    }
}

string DictionaryGame::generate_words(string& source) {
    srand(time(0));
    int source_seed = rand() % dictionary.size();
    int target_seed = rand() % dictionary.size();
    source = dictionary[source_seed];
    string target = dictionary[target_seed];
    return target;
}

int main() {
    DictionaryGame g1("WordList.txt");
    string source = "";
    string target = g1.generate_words(source);
    g1.run_game(source, target);
}
