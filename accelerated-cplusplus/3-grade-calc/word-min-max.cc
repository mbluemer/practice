#include <iostream>
#include <algorithm>
#include <string>

using std::cout;            using std::cin;
using std::max;             using std::min;
using std::endl;            using std::string;

int main()
{
    double maxLen = std::numeric_limits<double>::min();
    double minLen = std::numeric_limits<double>::max();

    cout << "Please enter a bunch of words followed by EOF: " << endl;

    string x;
    while (cin >> x) {
        double size = x.size();
        maxLen = max(maxLen, size);
        minLen = min(minLen, size);
    }

    cout << "The longest word is: " << maxLen << endl;
    cout << "The shortest word is: " << minLen << endl;

    return 0;
}
