#ifndef MATERIAL_H
#define MATERIAL_H

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

        friend ostream& operator<<(ostream& os, Material &material); 
};

#endif