package com.meuprojeto.logistica.sustentacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);
    private final PedidoRepository repository;

    public PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        logger.info("Recebendo novo pedido de: {}", pedido.getProduto());
        pedido.setStatus("PROCESSADO");
        return repository.save(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        logger.info("Consultando todos os pedidos no banco de dados.");
        return repository.findAll();
    }

    // SIMULADOR DE ERRO PARA A ENTREVISTA
    @GetMapping("/testar-erro")
    public void forçarErro() {
        logger.error("ALERTA: Tentativa de processamento falhou critícamente!");
        throw new RuntimeException("Erro simulado para teste de sustentação.");
    }
}