#ifndef ESTUDO_H
#define ESTUDO_H

#include "../Incluidor.h"

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

        friend ostream& operator<<(ostream& os, Estudo &Estudo); 
};

#endif