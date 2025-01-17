package br.com.zup.ot6.izabel.casadocodigo.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Autor;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {
	
	Optional<Autor>  findByEmail(String email);

}
