package com.lojaAPP.applicationAPI.Modules.Pedidos.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lojaAPP.applicationAPI.Modules.Pedidos.DTO.NovoPedidoDTO;
import com.lojaAPP.applicationAPI.Modules.Pedidos.Enum.StatusPedido;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Usuario usuarioPedido;

    @ManyToMany(mappedBy = "pedidos", fetch = FetchType.EAGER)
    private List<Produtos> produtosPedido;

    public Pedidos(Usuario usuario, List<Produtos> produtos){
        this.statusPedido = StatusPedido.PAGAMENTO;
        this.usuarioPedido = usuario;
        this.produtosPedido = produtos;
    }

}
