package pp2.ifpe.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pedido {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@DecimalMin(value = "0.01")
	private double valor;
	@Min(value = 0)
	private int qtd;
	@DateTimeFormat(pattern = "MM/dd/yyyy") @FutureOrPresent
	private Date data;
	private String pedidopaypal;
	private boolean status;
	private String qrcode;
	@ManyToOne
	private Ingresso ingresso;
	@ManyToOne
	private Usuario usuario;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getPedidopaypal() {
		return pedidopaypal;
	}
	public void setPedidopaypal(String pedidopaypal) {
		this.pedidopaypal = pedidopaypal;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public Ingresso getIngresso() {
		return ingresso;
	}
	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
