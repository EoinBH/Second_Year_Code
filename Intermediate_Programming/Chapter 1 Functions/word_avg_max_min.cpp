/* average, minimum, maximum */

#include <fstream>
#include <string>
#include <iostream>
#include "chap1.h"
using namespace std;

int void chap1::wordAvg() {

  ifstream input; /* creates a stream, not attached to anything */
  int minimum, maximum, count, len, total_length;
  float average;
  string word;

  minimum = maximum = total_length = count = 0;

  input.open("wordsfile"); /* attach stream to a file */

  while(input >> word) {

    len = word.size();

    /* up the count of words */
    count++;

    /* up the total word length */
    total_length = total_length + len;

    /* update minimum word length */
    if (count == 1) {
      minimum = len;
    }
    else if (len < minimum) {
      minimum = len;
    }

    /* update maximum word length */
    if (count == 1) {
      maximum = len;
    }
    else if (len > maximum) {
      maximum = len;
    }
  }

  /* calculate the average */
  average = ((float)total_length)/count;

  /* print out all the answers */
  cout << "average is " << average << '\n';
  cout << "minimum is " << minimum << '\n';
  cout << "maximum is " << maximum << '\n';

}
