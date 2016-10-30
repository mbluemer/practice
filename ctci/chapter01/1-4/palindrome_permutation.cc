#include <string>
#include <iostream>
#include <map> 

using std::string;          using std::cout;
using std::cin;             using std::endl;
using std::map;

map<char, int> map_string(string s) {
    map<char, int> ret;

    for (string::size_type i = 0; i < s.size(); i++) {
        ret[s[i]]++;
    }
    return ret;
}

bool is_even(int x)
{
    return x % 2 == 0;
}

bool is_palindrome_permutation(string s)
{
    // First remove all spaces and modify length of container
    s.erase(remove_if(s.begin(), s.end(), isspace), s.end());

    // map the string
    map<char, int> char_map = map_string(s);

    // check if it's a palindrome
    bool found_odd_char = false;
    bool is_even_chars = is_even(s.size());
    
    map<char, int>::const_iterator it = char_map.begin();
    while (it != char_map.end()) {
        if (!is_even(it->second)) {
            if (is_even_chars) return false;
            else if (found_odd_char) return false;
            else found_odd_char = true;
        }
        it++;
    }
    return true;
}

int main()
{
    string test;
    cout << "Please enter a string ending with EOF: ";
    getline(cin, test);
    cout << (is_palindrome_permutation(test) ? "A permutation of the given string is a palindrome." :
            "The given string has no permutations that are palindromes.") << endl;

    return 0;
}
