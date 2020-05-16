package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Usuario;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {

	private String cpf;
	private String senha;

	private List<Usuario> listaUsuarios;
	private Usuario usuario; 
	private String msgCadastroUsuario;
	
	private UsuarioDAO usuarioDAO;

	/**
	 * Construtor, que vai inicializar a lista de usuarios
	 */
	public LoginBean() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuario = new Usuario();
		this.usuarioDAO = new UsuarioDAOImpl();
	}

	/**
	 * Metodo responsavel por validar o usuario no login
	 */
	public String entrar() {

		boolean achou = false;

		this.listaUsuarios = this.usuarioDAO.listarTodos();
		
		for (Usuario usuarioPesquisa : listaUsuarios) {

			if (usuarioPesquisa.getCpf().equals(this.cpf) && usuarioPesquisa.getSenha().equals(this.senha)) {

				achou = true;
			}
		}

		if (achou) {
			return "livro.xhtml";
		} else {
			return "login.xhtml";
		}

	}

	/**
	 * Metodo responsavel por criar um novo usuario na lista
	 */
	public void criarUsuario() {

		Usuario novo = new Usuario();

		novo.setNome(this.usuario.getNome());
		novo.setCpf(this.usuario.getCpf());
		novo.setSenha(this.usuario.getSenha());

		boolean achou = false;
		
		this.listaUsuarios = this.usuarioDAO.listarTodos();
		
		for (Usuario usuarioPesquisa : listaUsuarios) {
			if (usuarioPesquisa.getCpf().equals(this.usuario.getCpf())) {
				achou = true;
			}
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario j� existe!!!"));
		}else {
//			this.listaUsuarios.add(novo);
			this.usuarioDAO.inserir(novo);
			
			this.usuario = new Usuario();	
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMsgCadastroUsuario() {
		return msgCadastroUsuario;
	}

	public void setMsgCadastroUsuario(String msgCadastroUsuario) {
		this.msgCadastroUsuario = msgCadastroUsuario;
	}

}
