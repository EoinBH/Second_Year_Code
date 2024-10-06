#include <iostream>
#include "Person.h"
using namespace std;

void Person::zero(void) {
age = 0;
height = 0;
}

void Person::print(void) {
cout << " age " << age << '\n';
cout << " height " << height << '\n';
}

void Person::add_one(void) {
age++;
}
