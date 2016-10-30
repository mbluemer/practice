#include <string>
#include <map>
#include <iostream>
#include <iomanip>

using std::string;          using std::map;
using std::cout;            using std::cin;
using std::endl;

bool is_char_unique(string s)
{
    map<char, int> table;
    for (string::size_type i = 0; i < s.size(); i++) {
        if (table.find(s[i]) != table.end()) {
            return false;
        } else {
            table[s[i]] = 1;
        }
    }
    return true;
}

int main()
{
    cout << "Please enter a string: ";
    string test;
    cin >> test;

    cout << std::boolalpha << is_char_unique(test) << endl;

    return 0;
}
