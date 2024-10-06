#include <string>
#include <iostream>
#include <fstream>
#include <vector>
using namespace std;

struct CodePair {
    char plain;
    string code;
};

class Morse {
public:
    Morse(string fname);
    string encode_a_letter(char c);
    char decode_a_letter(string code);
    string encode_a_word(string w);
    string decode_a_word(string w);
    string decode_a_word_seq(string w);
private:
    vector<CodePair> code_table;
};

Morse::Morse(string fname) {
    bool is_character = true;
    string line = "";
    ifstream f;
    CodePair pair;
    f.open(fname);
    if(f) {
        while(f >> line) {
            if (is_character) {
                char c = line[0];
                pair.plain = c;
                is_character = false;
            }
            else {
                pair.code = line;
                code_table.push_back(pair);
                is_character = true;
            }
        }
    }
    else {
        cout << "Failed to open file" << "\n";
    }
}

string Morse::encode_a_letter(char c) {
    for (int i = 0; i < code_table.size(); i++) {
        if (code_table[i].plain == c) {
            if (code_table[i].code != "") {
                return code_table[i].code;
            }
        }
    }
    return "****";
}

char Morse::decode_a_letter(string s) {
    for (int i = 0; i < code_table.size(); i++) {
        if (code_table[i].code == s) {
            if (code_table[i].plain != '\0') {
                return code_table[i].plain;
            }
        }
    }
    return '*';
}

string Morse::encode_a_word(string w) {
    bool is_valid = true;
    string result = "";
    for (int i = 0; i < w.length(); i++) {
        if (encode_a_letter(w[i]) == "****") {
            is_valid = false;
        }
        else {
            if (i == (w.length() - 1)) {
                result += encode_a_letter(w[i]);
            }
            else {
                result = result + encode_a_letter(w[i]) + "   ";
            }
        }
    }
    if (is_valid) {
        return result;
    }
    else {
        return "";
    }
}

string Morse::decode_a_word(string w) {
    vector<string> codes = w.split(w, 3);
    bool is_valid = true;
    string result = "";
    for (int i = 0; i < codes.size(); i++) {
        if (decode_a_letter(codes[i]) == '*') {
            is_valid = false;
        }
        else {
            result += string(1, decode_a_letter(codes[i]));
        }
    }
    if (is_valid) {
        return result;
    }
    else {
        return "";
    }
}

string Morse::decode_a_word_seq(string w) {
    vector<string> code_sequences = w.split(w, 7);
    bool is_valid = true;
    string result = "";
    for (int i = 0; i < code_sequences.size(); i++) {
        if (decode_a_word(code_sequences[i]) == "") {
            is_valid = false;
        }
        else {
            if (i == (code_sequences.size() - 1)) {
                result += decode_a_word(code_sequences[i]);
            }
            else {
                result = result + decode_a_word(code_sequences[i]) + " ";
            }
        }
    }
    if (is_valid) {
        return result;
    }
    else {
        return "";
    }
}

int main() {
    Morse o1("MorseCode");
}
