#include <iostream>
#include <string>

using namespace std;

class Material {
    string nome;
    string link;

    public:
        Material (string nome, string link);

        string obterNome();
        string obterLink();
};