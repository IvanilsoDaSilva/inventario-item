package br.com.ic.inventarioitem.service;

import br.com.ic.inventarioitem.entities.core.Item;
import br.com.ic.inventarioitem.enums.CategoriaItem;
import br.com.ic.inventarioitem.repositories.ItemRepository;
import br.com.ic.inventarioitem.services.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
public class ItemServiceTests {
    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemService itemService;

    @Test
    void criarItemSucesso() {
        Item mock = Item.builder()
                .nome("Produto")
                .codigo("123")
                .categoria(CategoriaItem.AUTOMOVEL)
                .build();

        when(itemRepository.save(any(Item.class))).thenReturn(mock);

        Item resultado = itemService.create(Item.builder().build());

        assertNotNull(resultado);
        assertEquals("Produto", resultado.getNome());
        assertEquals("123", resultado.getCodigo());
        assertEquals(CategoriaItem.AUTOMOVEL, resultado.getCategoria());

        verify(itemRepository, times(1)).save(any(Item.class));
    }

    @Test
    void lerItemPorNomeSucesso() {
        Item mock = Item.builder()
                .nome("Produto")
                .codigo("123")
                .categoria(CategoriaItem.AUTOMOVEL)
                .build();

        when(itemRepository.findByNome(any(String.class))).thenReturn(mock);

        Item resultado = itemService.readByNome("Produto");

        assertNotNull(resultado);
        assertEquals("Produto", resultado.getNome());
        assertEquals("123", resultado.getCodigo());
        assertEquals(CategoriaItem.AUTOMOVEL, resultado.getCategoria());

        // Verifica se o repositório foi chamado corretamente
        verify(itemRepository, times(1)).findByNome(any(String.class));
    }

    @Test
    void lerTodosItemsSucesso() {
        List<Item> mockUsuarios = Arrays.asList(
                Item.builder()
                        .nome("Produto")
                        .codigo("123")
                        .categoria(CategoriaItem.AUTOMOVEL)
                        .build()
        );

        when(itemRepository.findAll()).thenReturn(mockUsuarios);

        List<Item> resultado = itemService.readAll();

        assertNotNull(resultado);
        assertEquals("Produto", resultado.get(0).getNome());
        assertEquals("123", resultado.get(0).getCodigo());
        assertEquals(CategoriaItem.AUTOMOVEL, resultado.get(0).getCategoria());

        verify(itemRepository, times(1)).findAll();
    }

    @Test
    void deletarItemSucesso() {
        Item mock = Item.builder()
                .nome("Produto")
                .codigo("123")
                .categoria(CategoriaItem.AUTOMOVEL)
                .build();

        doNothing().when(itemRepository).delete(any(Item.class));

        itemService.delete(mock);

        verify(itemRepository, times(1)).delete(any(Item.class));
    }
}