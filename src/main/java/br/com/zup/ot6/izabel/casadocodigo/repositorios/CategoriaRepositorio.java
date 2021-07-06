package br.com.zup.ot6.izabel.casadocodigo.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{

	Optional<Categoria> findByNome(String nome);
}
