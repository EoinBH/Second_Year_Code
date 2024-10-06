#include <iostream>
#include "chap1.h"
using namespace std;

int void chap1::birthday() {
  int mm; /* month of birthday */
  int dd; /* day of birthday */
  int i, j;
  mm = 2;
  dd = 25;

  for (i=0; i < mm; i++) {
    for(j=0; j < dd; j++) {
      cout << "*";
    }
    cout << "\n";
  }
 


}
