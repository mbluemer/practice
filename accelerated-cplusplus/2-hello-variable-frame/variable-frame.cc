#include <iostream>
#include <string>

int main()
{
    std::cout << "Please enter your first name: ";

    std::string name;
    std::cin >> name;

    const std::string greeting = "Hello, " + name + "!";

    // the number of blanks surrounding the greeting
    const int pad = 1;
    
    // the total number of rows to write
    const int rows = pad * 2 + 3;

    std::cout << std::endl;

    int i = 0;
    while ( i != rows) {
        const std::string::size_type cols = greeting.size() + pad * 2 + 2;
        std::string::size_type c = 0;
        while (c != cols) {
            if (i == 0 || i == rows -1 || c == 0 || c == cols - 1) {
                std::cout << "*";
                ++c;
            } else {
                if (i == pad + 1 && c == pad + 1) {
                    std::cout << greeting;
                    c += greeting.size();
                } else {
                    std::cout << " ";
                    ++c;
                }
            }
        }

        std::cout << std::endl;
        ++i;
    }

    return 0;
}
