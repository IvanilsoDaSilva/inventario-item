package br.com.ic.inventarioitem.runners;

import br.com.ic.inventarioitem.entities.core.*;
import br.com.ic.inventarioitem.enums.PapelUsuario;
import br.com.ic.inventarioitem.enums.TipoLoja;
import br.com.ic.inventarioitem.repositories.*;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class BancoDadosRunner implements ApplicationRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public void run(ApplicationArguments args) {
        usuarioRepository.saveAll(
                List.of(
                        Usuario.builder()
                                .nome("João Silva")
                                .email("joao.silva@domain.com")
                                .cpf("111.222.333-44")
                                .senha("123")
                                .papel(PapelUsuario.COMUM)
                        .build(),
                        Usuario.builder()
                                .nome("Maria Souza")
                                .email("maria.souza@domain.com")
                                .cpf("222.333.444-55")
                                .senha("123")
                                .papel(PapelUsuario.COMUM)
                        .build()
                )

        );

        proprietarioRepository.saveAll(
                List.of(
                        Proprietario.builder()
                                .nome("Carlos Ferreira")
                                .email("carlos.ferreira@domain.com")
                                .cpf("333.444.555-66")
                        .build(),
                        Proprietario.builder()
                                .nome("Ana Oliveira")
                                .email("ana.oliveira@domain.com")
                                .cpf("444.555.666-77")
                        .build()
                )
        );

        fabricanteRepository.saveAll(
                List.of(
                        Fabricante.builder()
                                .razaoSocial("Indústria de Tecnologia Alpha LTDA")
                                .cnpj("12.345.678/0001-90")
                                .email("contato@alpha-tech.com")
                                .site("www.alpha-tech.com")
                        .build(),
                        Fabricante.builder()
                                .razaoSocial("Fábrica de Móveis Beta S.A.")
                                .cnpj("98.765.432/0001-11")
                                .email("vendas@beta-moveis.com")
                                .site("www.beta-moveis.com")
                        .build()
                )
        );

        fornecedorRepository.saveAll(
                List.of(
                        Fornecedor.builder()
                                .razaoSocial("Metalúrgica Gamma LTDA")
                                .cnpj("23.456.789/0001-12")
                                .email("comercial@gamma-metalurgica.com")
                                .site("www.gamma-metalurgica.com")
                        .build(),
                        Fornecedor.builder()
                                .razaoSocial("Tecidos Delta Importações S.A.")
                                .cnpj("34.567.890/0001-23")
                                .email("suporte@delta-tecidos.com")
                                .site("www.delta-tecidos.com")
                        .build()
                )
        );

        vendedorRepository.saveAll(
                List.of(
                        Vendedor.builder()
                                .razaoSocial("Distribuidora de Alimentos Omega LTDA")
                                .cnpj("12.345.678/0001-90")
                                .email("contato@omega-alimentos.com")
                                .site("www.omega-alimentos.com")
                                .tipoLoja(TipoLoja.FISICA)
                                .build(),

                        Vendedor.builder()
                                .razaoSocial("Comércio de Eletrônicos Sigma S.A.")
                                .cnpj("98.765.432/0001-11")
                                .email("suporte@sigma-eletronicos.com")
                                .site("www.sigma-eletronicos.com")
                                .tipoLoja(TipoLoja.VIRTUAL)
                                .build()
                )
        );
    }
}