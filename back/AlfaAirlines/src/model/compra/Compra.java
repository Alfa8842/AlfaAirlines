package model.compra;

import model.pacote.Pacote;
import model.usuario.Usuario;

	public class Compra {
		private int id;
		private Usuario usuario; 
		private Pacote pacote;
		
		public Compra(int id, Usuario usuario, Pacote pacote) {
			super();
			this.id = id;
			this.usuario = usuario;
			this.pacote = pacote;
		}
		
		public Compra(Usuario usuario, Pacote pacote) {
			super();
			this.id = -1;
			this.usuario = usuario;
			this.pacote = pacote;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Pacote getPacote() {
			return pacote;
		}

		public void setPacote(Pacote pacote) {
			this.pacote = pacote;
		}

		
		
	}
