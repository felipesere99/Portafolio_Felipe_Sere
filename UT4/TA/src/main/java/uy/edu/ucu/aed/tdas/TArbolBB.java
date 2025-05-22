package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;
import java.util.List;

public class TArbolBB<T> implements IArbolBB<T> {
	private IElementoAB<T> raiz;

	@Override
	public List<T> postOrden() {
		LinkedList<T> l = new LinkedList<T>();
		if (this.raiz != null) {
			this.raiz.postOrden(l);
		}
		return l;
	}

	@Override
	public List<T> preOrden() {
		LinkedList<T> l = new LinkedList<T>();
		if (this.raiz != null) {
			this.raiz.preOrden(l);
		}
		return l;
	}

	@Override
	public List<T> inOrden() {
		LinkedList<T> l = new LinkedList<T>();
		if (this.raiz != null) {
			this.raiz.inOrden(l);
		}
		return l;
	}

	@Override
	public Integer getAltura() {
		if (this.raiz == null) {
			return -1;
		}
		return this.raiz.getAltura();
	}

	@Override
	public boolean insertar(Comparable key, T value) {
		if (this.raiz == null) {
			this.raiz = new TElementoAB<T>(key, value);
			return true;
		} else {
			TElementoAB<T> newElemento = new TElementoAB<T>(key, value);
			return this.raiz.insertar(newElemento);
		}
	}

	@Override
	public IElementoAB<T> buscar(Comparable key) {
		if (raiz != null) {
			try {
				return raiz.buscar(key);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public void eliminar(Comparable key) {
		if (this.raiz != null) {
			this.raiz = this.raiz.eliminar(key);
		}
	}

	@Override
	public boolean esVacio() {
		if (this.raiz == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean vaciar() {
		if (this.raiz == null) {
			return false;
		}
		this.raiz = null;
		return true;
	};

	@Override
	public int obtenerTamaño() {
		if (raiz != null) {
			return raiz.obtenerTamaño();
		}
		return 0;
	}
}
