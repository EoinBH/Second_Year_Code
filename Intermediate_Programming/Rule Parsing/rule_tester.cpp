#include "Rule.h"

int main() {
  
  Rule r("vp --> vb,adj");
  r.show();
    
  Rule r1("np --> adj,n");
  r1.show();
    
  Rule r2("vp --> v,np,np");
  r2.show();
}
