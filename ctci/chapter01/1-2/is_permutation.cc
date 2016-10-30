#include <string>
#include <map>
#include <iostream>

using std::string;          using std::map;
using std::cout;            using std::cin;
using std::endl;

map<char, int> map_string(string s)
{
    map<char, int> ret;
    for (string::size_type i = 0; i < s.size(); i++) {
        ret[s[i]] = ((ret.find(s[i]) != ret.end()) ? ret[s[i]] + 1 : 1);
    }
    return ret;
}

bool string_map_equal(map<char, int>& a, map<char, int>& b)
{
    // If they aren't the same size then they're not the same
    if (a.size() != b.size())
        return false;

    // Now let's check every individual element
    map<char, int>::const_iterator iterA = a.begin();
    map<char, int>::const_iterator iterB = b.begin();
    
    while (iterA != a.end() && iterB != b.end()) {
        if (iterA->second != iterB->second) 
            return false;
        iterA++;
        iterB++;
    }
    return true;
}

bool is_permutation(string a, string b)
{
    map<char, int> a_map = map_string(a);
    map<char, int> b_map = map_string(b);

    return string_map_equal(a_map, b_map);
}

int main()
{
    string a, b;
    cout << "Please enter two strings: ";
    cin >> a;
    cin >> b;
    cout << (is_permutation(a, b) ? "The strings are permutations of one another." :
                                "The strings aren't permutations of one another.") << endl;

    return 0;
}
