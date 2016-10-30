#include <iostream>
#include <string>
#include <map>
#include <vector>

using std::string;              using std::map;
using std::vector;              using std::istream;
using std::cout;                using std::cin;
using std::endl;

bool space(char c)
{
    return isspace(c);
}

bool not_space(char c)
{
    return !isspace(c);
}

vector<string> split(const string& str)
{
    typedef string::const_iterator iter;
    vector<string> ret;

    iter i = str.begin();
    while (i != str.end()) {
        i = find_if(i, str.end(), not_space);
        iter j = find_if(i, str.end(), space);
        if (i != str.end()) {
            ret.push_back(string(i, j));
        }
        i = j;
    }
    return ret;
}

map<string, vector<int> >
    xref(istream& in, vector<string> find_words(const string&)= split)
{
    string line;
    int line_number = 0;
    map<string, vector<int> > ret;

    // read the next line
    while (getline(in, line)) {
        ++line_number;

        // break the input line into words
        vector<string> words = find_words(line);

        // remember that each word occurs on the current line
        for (vector<string>::const_iterator it = words.begin();
                it != words.end(); ++it) {
            ret[*it].push_back(line_number);
        }
    }
    return ret;
}

int main()
{
    map<string, vector<int> > test = xref(cin);

    for (map<string, vector<int> >::const_iterator iter = test.begin();
            iter != test.end(); iter++) {
        cout << "********" << iter->first << "*******" << endl;
        for (vector<int>::const_iterator it = iter->second.begin();
                it != iter->second.end(); it ++) {
            cout << *it << endl;
        }
    }
    return 0;
}
