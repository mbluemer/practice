#include <iostream>
#include <map>
#include <string>

using std::cout;            using std::cin;
using std::string;          using std::map;
using std::endl;

int main ()
{
    string s;
    map<string, int> counters; //stpre each word and an associated counter

    // read the input, keeping track of each word and how often we see it
    while (cin >> s)
        ++counters[s];

    // write the words and the associated counts
    for (map<string, int>::const_iterator it = counters.begin();
            it != counters.end(); ++it) {
        cout << it->first << "\t" << it->second << endl;
    }
    return 0;
}
