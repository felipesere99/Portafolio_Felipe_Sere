package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;

public class TElementoAB<T> implements IElementoAB<T> {
	private T datos;
	private Comparable etiqueta;
	private IElementoAB<T> izq;
	private IElementoAB<T> der;

	public TElementoAB(Comparable key, T value) {
		this.etiqueta = key;
		this.datos = value;
	}

	@Override
	public Comparable getEtiqueta() {
		return this.etiqueta;
	}

	@Override
	public T getDatos() {
		return this.datos;
	}

	@Override
	public IElementoAB<T> getHijoIzq() {
		return this.izq;
	}

	@Override
	public IElementoAB<T> getHijoDer() {
		return this.der;
	}

	@Override
	public void setHijoIzq(IElementoAB<T> elemento) {
		this.izq = elemento;
	}

	@Override
	public void setHijoDer(IElementoAB<T> elemento) {
		this.der = elemento;
	}

	@Override
	public Integer getAltura() {
		Integer altura = 0;
		if (this.getHijoDer() == null && this.getHijoIzq() == null) {
			return altura;
		}
		Integer alturaIzq = 0;
		Integer alturaDer = 0;
		if (this.getHijoDer() != null) {
			alturaDer = this.getHijoDer().getAltura();
		}
		if (this.getHijoIzq() != null) {
			alturaIzq = this.getHijoIzq().getAltura();
		}
		altura = Math.max(alturaDer, alturaIzq) + 1;
		return altura;
	}

	@Override
	public IElementoAB<T> buscar(Comparable unaEtiqueta) throws Exception {
		if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
			if (this.getHijoIzq() == null) {
				throw new Exception("el elemento no existe");
			}
			return this.getHijoIzq().buscar(unaEtiqueta);
		} else if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
			if (this.getHijoDer() == null) {
				throw new Exception("el elemento no existe");
			}
			return this.getHijoDer().buscar(unaEtiqueta);
		} else {
			return this;
		}
	}

	@Override
	public boolean insertar(IElementoAB<T> elemento) {
		if (elemento.getEtiqueta().compareTo(this.getEtiqueta()) < 0) {
			if (this.getHijoIzq() == null) {
				this.setHijoIzq(elemento);
				return true;
			} else {
				return this.getHijoIzq().insertar(elemento);
			}
		} else if (elemento.getEtiqueta().compareTo(this.getEtiqueta()) > 0) {
			if (this.getHijoDer() == null) {
				this.setHijoDer(elemento);
				return true;
			} else {
				return this.getHijoDer().insertar(elemento);
			}
		} else {
			return false;
		}
	}

	@Override
	public IElementoAB<T> eliminar(Comparable unaEtiqueta) {
		if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
			if (this.izq != null) {
				this.izq = this.izq.eliminar(unaEtiqueta);
			}
		} else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
			if (this.der != null) {
				this.der = this.der.eliminar(unaEtiqueta);
			}
		} else {
			if (this.izq == null && this.der == null) {
				return null;
			} else if (this.izq == null) {
				return this.der;
			} else if (this.der == null) {
				return this.izq;
			} else {
				// Caso 3: Tiene ambos hijos
				IElementoAB<T> sucesor = this.der.obtenerMinimo();
				this.etiqueta = sucesor.getEtiqueta();
				this.datos = sucesor.getDatos();
				this.der = this.der.eliminar(sucesor.getEtiqueta());
			}
		}
		return this;
	}

	public IElementoAB<T> obtenerMinimo() {
		if (this.izq == null) {
			return this;
		}
		return this.izq.obtenerMinimo();
	}

	@Override
	public void preOrden(LinkedList<T> unaLista) {
		LinkedList<T> izq = new LinkedList<T>();
		LinkedList<T> der = new LinkedList<T>();
		if (this.getHijoIzq() != null) {
			this.getHijoIzq().preOrden(izq);
		}
		if (this.getHijoDer() != null) {
			this.getHijoDer().preOrden(der);
		}

		unaLista.add(this.getDatos());
		unaLista.addAll(izq);
		unaLista.addAll(der);
	}

	@Override
	public void inOrden(LinkedList<T> unaLista) {
		LinkedList<T> izq = new LinkedList<T>();
		LinkedList<T> der = new LinkedList<T>();
		if (this.getHijoIzq() != null) {
			this.getHijoIzq().inOrden(izq);
		}
		if (this.getHijoDer() != null) {
			this.getHijoDer().inOrden(der);
		}

		unaLista.addAll(izq);
		unaLista.add(this.getDatos());
		unaLista.addAll(der);
	}

	@Override
	public void postOrden(LinkedList<T> unaLista) {
		LinkedList<T> izq = new LinkedList<T>();
		LinkedList<T> der = new LinkedList<T>();
		if (this.getHijoIzq() != null) {
			this.getHijoIzq().postOrden(izq);
		}
		if (this.getHijoDer() != null) {
			this.getHijoDer().postOrden(der);
		}

		unaLista.addAll(izq);
		unaLista.addAll(der);
		unaLista.add(this.getDatos());
	}

	@Override
	public int obtenerTamaño() {
		int size = 1;
		if (this.getHijoIzq() != null) {
			size += this.getHijoIzq().obtenerTamaño();
		}
		if (this.getHijoDer() != null) {
			size += this.getHijoDer().obtenerTamaño();
		}
		return size;
	}
}
