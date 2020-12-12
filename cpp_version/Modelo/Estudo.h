#include <iostream>
#include <string>
#include <vector>
#include "Atividade.h"
#include "Material.h"

using namespace std;

class Estudo : public Atividade{
    vector<Material> materiais;

    public:
        Estudo (string nome, bool sincrona, vector<Material> materiais) : 
        Atividade(nome, sincrona){
            this->materiais = materiais;
        }
        // ~Estudo();

        vector<Material> getMateriais();
        bool ehAvaliativa();
};