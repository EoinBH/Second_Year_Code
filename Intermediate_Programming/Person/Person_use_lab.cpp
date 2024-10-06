#include <iostream>
#include "Person.h"
using namespace std;

int main() {
  Person fred;
  fred.age = 3;
  fred.height = 10;
  fred.print();
  fred.zero();
  fred.print();
  fred.add_one();
  fred.print();
}
