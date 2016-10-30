#include <iostream>
#include <algorithm>

using std::cout;        using std::endl;
using std::cin;         using std::max;


int main () {
    int a; int b;
    cout << "Please enter two numbers: ";
    cin >> a >> b;
    cout << "The max of the two numbers is: " << max(a, b);

    return 0;
}
