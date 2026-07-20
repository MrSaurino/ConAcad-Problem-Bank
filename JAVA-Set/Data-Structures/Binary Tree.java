public class arbol {
    Nodo raiz;
    void insert(int dato){
        Nodo aux;
        Nodo temp=new Nodo(dato);
        if(raiz==null)
            raiz=temp;
        else {
            aux = raiz;
            while(aux!=null&&aux.info!=dato) {
                if(dato<aux.info)
                    aux=aux.Izq;
                else
                    aux=aux.Der;
            }
        }
    }
    void borrar(int dato){
        if(raiz==null)
            System.out.println("Underflow");
        else{
            Nodo Ancestro= buscarNodo(dato);
            if(dato<Ancestro.info)
                if(Ancestro.Izq==null)
                    System.out.println("Underflow");
                else
                    borrarNodo(Ancestro,false);
                    else if(Ancestro.Der==null)
                    System.out.println("Underflow");
                else
                    borrarNodo(Ancestro,true);
        }
    }
    Nodo buscarNodo(int dato){
        Nodo atras,aux;
        aux=atras=raiz;
        while(aux!=null&&aux.info!=dato){
            atras=aux;
            if(dato<aux.info)
                aux=aux.Izq;
            else
                aux=aux.Der;
        }
        return atras;
    }
    void borrarNodo(Nodo Padre, boolean bandera){
        Nodo borrar, temp,vig=null;
        if(bandera)
            borrar=Padre.Der;
        else
            borrar=Padre.Izq;
       if(borrar.Izq==null&&borrar.Izq==null)
            if(bandera)
                Padre.Der=null;
            else
                Padre.Izq=null;
        else
            if(borrar.Der!=null&&borrar.Izq!=null) {
                temp = borrar.Izq;
                while (temp.Der != null) {
                    vig = temp;
                    temp=temp.Der;
                }
                if(temp.Izq==null&&temp.Der==null){
                    borrar.info=temp.info;
                    vig.Der=null;
                }else{

                }

            }
                else
                    if(borrar.Izq!=null)
                        if(bandera)
                            Padre.Der=borrar.Izq;
                        else
                            Padre.Izq=borrar.Izq;
                    else
                        if(bandera)
                            Padre.Der=borrar.Der;
                        else
                            Padre.Izq=borrar.Der;
    }
void inorder(Nodo aux){
        if(aux.Izq!=null)
            inorder(aux.Izq);
    System.out.println(aux.info);
        if(aux.Der!=null)
            inorder(aux.Der);
}
}
class pagina{
    pagina arre[];
    int datos[];
    pagina(int orden){
        arre=new pagina[2*orden+1];
        datos=new int[2*orden+1];
    }
}
