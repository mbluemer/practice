#include <vector>
#include <string>
#include <iostream>

using std::string;          using std::vector;
using std::cout;            using std::endl;
using std::max;

// Given a string s, return a vector<string> containing each word that was in s
vector<string> split(const string& s)
{
    vector<string> ret;
    typedef string::size_type string_size;
    string_size i = 0;

    while (i != s.size()) {
        // ignore leading blanks
        while (i != s.size() && isspace(s[i]))
            ++i;

        // find end of next word
        string_size j = i;
        while (j != s.size() && !isspace(s[j]))
            ++j;

        // if we found some nonwhitespace characters
        if (i != j) {
            // copy from s starting at i and taking j-i characters
            ret.push_back(s.substr(i, j-i));
            i = j;
        }
    }
    return ret;
}

// Given a vector<string> return the size of the longest string in the vector
string::size_type width(const vector<string>& v)
{
    string::size_type maxlen = 0;
    for (string::size_type i = 0; i < v.size(); i++)
        maxlen = max(maxlen, v[i].size());
    return maxlen;
}

// Given a vector<string> v return a vector<string> containing a line by line
// framed version of the original set of strings
vector<string> frame(const vector<string> v)
{
    vector<string> ret;
    string::size_type maxlen = width(v);
    string border(maxlen + 4, '*');

    // write the top border
    ret.push_back(border);

    // write each interior row, bordered by an asterisk and a space
    for (string::size_type i = 0; i < v.size(); i++)
        ret.push_back("* " + v[i] + string(maxlen - v[i].size(), ' ') + " *");

    // write the bottom border
    ret.push_back(border);
    return ret;
}

int main()
{
    string test = "This is a test";
    vector<string> words = split(test);
    vector<string> words_framed = frame(words);

    for (string::size_type i = 0; i < words_framed.size(); i++) {
        cout << words_framed[i] << endl;
    }
    return 0;
}
