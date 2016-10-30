#include <string>
#include <iostream>
#include <iomanip>

using std::string;          using std::cout;
using std::cin;             using std::endl;

string urlify(string s)
{
    string ret;
    for (string::size_type i = 0; i < s.size(); i++) {
        if (isspace(s[i])) {
            ret += "%20";
        } else {
            ret += s[i];
        }
    }
    return ret;
}

int main() 
{
    string test;
    cout << "Please enter a string: ";
    getline(cin, test);
    cout << urlify(test) << endl;

    return 0;
}

/* Note:
 * The book discusses an in-place algorithm that uses 
 * a character array. Despite the use of extra space
 * I chose to stick with this method since it only requires
 * one pass along the string and it is much more elegant.
 */
