package com.salao;

import com.salao.entity.*;
import com.salao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SalaoApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProfissionalRepository profissionalRepository;
    @Autowired
    private ComandaRepository comandaRepository;
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private ServicoRealizadoRepository servicoRealizadoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SalaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Paulo");
        cliente1.setEmail("Paulo@Teste");
        cliente1.setDataNascimento(LocalDate.now());
        cliente1.setTelefone("434234234");


        Cliente cliente2 = new Cliente();
        cliente2.setNome("PAvao");
        cliente2.setEmail("pavao@Teste");
        cliente2.setDataNascimento(LocalDate.now());
        cliente2.setTelefone("4342234");

        Cliente cliente3 = new Cliente();
        cliente3.setNome("Ramalho");

        Cliente cliente4 = new Cliente();
        cliente4.setNome("Marcelo");

        Cliente cliente5 = new Cliente();
        cliente5.setNome("Pedro");

        Cliente cliente6 = new Cliente();
        cliente6.setNome("Raissa");

        Cliente cliente7 = new Cliente();
        cliente7.setNome("Vanessa");

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);
        clienteRepository.save(cliente4);
        clienteRepository.save(cliente5);
        clienteRepository.save(cliente6);
        clienteRepository.save(cliente7);

        Profissional profissional1 = new Profissional();
        profissional1.setEmail("clararayssaaragao@hotmail.com");
        profissional1.setDataNascimento(LocalDate.now());
        profissional1.setTelefone("996425252");
        profissional1.setNome("Clara");

        profissionalRepository.save(profissional1);

        Servico servico1 = new Servico();
        servico1.setDescricao("pé e mão");
        servico1.setNome("pé e mão");
        servico1.setValor(BigDecimal.valueOf(42.90));
        servico1.setServicosRealizados(new HashSet<>());

        Servico servico2 = new Servico();
        servico2.setDescricao("maquiagem");
        servico2.setNome("maquiagem");
        servico2.setValor(BigDecimal.valueOf(75.0));
        servico2.setServicosRealizados(new HashSet<>());

        servicoRepository.save(servico1);
        servicoRepository.save(servico2);

        Comanda comanda1 = new Comanda();
        comanda1.setCliente(cliente1);
        comanda1.setData(LocalDateTime.now());
        comanda1.setFormaPagamento(FormaPagamento.CARTAO_CREDITO);
        comanda1.setValorTotal(BigDecimal.valueOf(143.90));

        comandaRepository.save(comanda1);

        ServicoRealizadoPK servicoRealizadoPK1 = new ServicoRealizadoPK();
        servicoRealizadoPK1.setServico(servicoRepository.findById(1L).get());
        servicoRealizadoPK1.setComanda(comandaRepository.findById(1L).get());
        // se tiver servico2 vai ter outro servico realizado e outro PK

        ServicoRealizadoPK servicoRealizadoPK2 = new ServicoRealizadoPK();
        servicoRealizadoPK2.setServico(servicoRepository.findById(2L).get());
        servicoRealizadoPK2.setComanda(comandaRepository.findById(1L).get());

        ServicoRealizado servicoRealizado1 = new ServicoRealizado();
        servicoRealizado1.setId(servicoRealizadoPK1);
        servicoRealizado1.setServico(servico1);
        servicoRealizado1.setDesconto(10.0);
        servicoRealizado1.setPreco(42.90 * 0.9); //calculando desconto de 10%
        servicoRealizado1.setQuantidade(1);  //quantidade geralmente vai ser 01, estudar excluir ou nao esse parametro
        servicoRealizado1.setProfissional(profissional1);

        ServicoRealizado servicoRealizado2 = new ServicoRealizado();
        servicoRealizado2.setId(servicoRealizadoPK2);
        servicoRealizado2.setServico(servico2);
        servicoRealizado2.setDesconto(0.0);
        servicoRealizado2.setPreco(75.0); //calculando desconto de 10%
        servicoRealizado2.setQuantidade(1);  //quantidade geralmente vai ser 01, estudar excluir ou nao esse parametro
        servicoRealizado2.setProfissional(profissional1);


        Set<ServicoRealizado> servicosRealizadosSet1 = new HashSet<>();
        servicosRealizadosSet1.add(servicoRealizado1);

        comanda1.setServicosRealizados(servicosRealizadosSet1);

        servicoRealizadoRepository.save(servicoRealizado1);
        servicoRealizadoRepository.save(servicoRealizado2);

    }
}
