public class Lista {
    Nodo inicio;
    Lista(){
        inicio=null;
    }
    void in(int dato){
        Nodo temp=new Nodo(dato);
        Nodo aux;
        if(inicio==null)
            inicio=temp;
        else if(dato<inicio.info){
            temp.siguiente=inicio;
            inicio=temp;
        }else {
            aux = buscPosition(dato);
            temp.siguiente = aux.siguiente;
            aux.siguiente = temp;
        }
    }
    Nodo buscPosition(int dato){
        Nodo aux=inicio;
        while(aux.siguiente!=null&&aux.siguiente.info<=dato)
            aux=aux.siguiente;
        return aux;
    }
    void m_out(int dato){
        Nodo aux;
        aux=buscPosition2(dato);
        aux.siguiente=aux.siguiente.siguiente;
    }
    Nodo buscPosition2(int dato){
        Nodo aux=inicio;
        while(aux.siguiente!=null&&aux.siguiente.info<dato)
            aux=aux.siguiente;
        return aux;
    }
}




