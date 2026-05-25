package com.anna.livros;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
  List<Livro> livros = new ArrayList<>(
    List.of(
      new Livro("1984", "George Orwell", "Distopia", 1949),
      new Livro("Cem Anos de Solidão", "Gabriel García Márquez", "Realismo Mágico", 1967),
      new Livro("O Nome da Rosa", "Umberto Eco", "Mistério Histórico", 1980),
      new Livro("Crime e Castigo", "Fiódor Dostoiévski", "Romance Psicológico", 1866),
      new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", 1954),
      new Livro("Dom Casmurro", "Machado de Assis", "Romance / Realismo", 1899)
    )
  );

  // GET /livros/todos -> retorna todos
  @GetMapping("/todos")
  public ResponseEntity<List<Livro>> listarTodos() {
    return ResponseEntity.ok(livros);
  }

  // GET /livros/1984 -> retorna informacoes apenas do livro 1984
  @GetMapping("/{titulo}")
  public ResponseEntity<Livro> listarPorTitulo(@PathVariable String titulo) {
    return livros.stream()
           .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
           .findFirst()
           .map(l -> ResponseEntity.ok(l))
           .orElse(ResponseEntity.notFound().build());
  }

  // GET /livros/genero?genero=distopia -> retorna livros do genero distopia
  @GetMapping("/genero")
  public ResponseEntity<List<Livro>> listarPorAno(@RequestParam String genero) {
    List<Livro> resultado = livros.stream()
           .filter(l -> l.getGenero().equalsIgnoreCase(genero))
           .collect(Collectors.toList()); // salva as ocorrencias

    if (resultado.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(resultado);
  }

  // GET /livros/apos_ano?ano=1950 -> apenas livros lançados apos 1950
  @GetMapping("/apos_ano")
  public ResponseEntity<List<Livro>> listarAposAno(@RequestParam int ano) {
    List<Livro> resultado = livros.stream()
           .filter(l -> l.getAno() > ano)
           .collect(Collectors.toList());

    if (resultado.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(resultado);
  }
}
