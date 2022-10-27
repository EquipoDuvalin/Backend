package com.losquemonitosdechill.Backend.articulo;

import java.net.URI;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articulo")

public class ArticuloController {
  @Autowired
  private ArticuloService articuloServices;

  @PostMapping(value = "/add")
  public ResponseEntity<Articulo> save(@RequestBody Articulo articulo) {
    Articulo newArticulo = articuloServices.create(articulo);
    try {
      return ResponseEntity.created(new URI("/api/articulo" + newArticulo.getCod_asociado())).body(newArticulo);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @PutMapping(value = "/update/{id}")
  public ResponseEntity<Articulo> updateArticulo(@PathVariable(value = "id") Integer id, @RequestBody Articulo articulo) {
    Optional<Articulo> articuloData = articuloServices.findById(id);

    if (articuloData.isPresent()) {
      Articulo newArticulo = articuloData.get();
      newArticulo.setCod_asociado(articulo.getCod_asociado());
      newArticulo.setId_clasificacion(articulo.getId_clasificacion());
      newArticulo.setCod_interno(articulo.getCod_interno());
      newArticulo.setCod_descripcion(articulo.getCod_descripcion());
      newArticulo.setDescripcion_corta(articulo.getDescripcion_corta());
      newArticulo.setCantidad_um(articulo.getCantidad_um());
      newArticulo.setId_unidad(articulo.getId_unidad());
      newArticulo.setId_proveedor(articulo.getId_proveedor());
      newArticulo.setPrecio_compra(articulo.getPrecio_compra());
      newArticulo.setUtilidad(articulo.getUtilidad());
      newArticulo.setUtilidad(articulo.getUtilidad());
      newArticulo.setPrecio_venta(articulo.getPrecio_venta());
      newArticulo.setTipo_articulo(articulo.getTipo_articulo());
      newArticulo.setStock(articulo.getStock());
      newArticulo.setStock_min(articulo.getStock_min());
      newArticulo.setStock_max(articulo.getStock_max());
      newArticulo.setIva(articulo.getIva());
      newArticulo.setKit_fecha_ini(articulo.getKit_fecha_ini());
      newArticulo.setKit_fecha_fin(articulo.getKit_fecha_fin());
      newArticulo.setArticulo_disponible(articulo.getArticulo_disponible());
      newArticulo.setKit(articulo.getKit());
      newArticulo.setFecha_registro(articulo.getFecha_registro());
      newArticulo.setVisible(articulo.getVisible());
      newArticulo.setPuntos(articulo.getPuntos());
      newArticulo.setLast_update_inventory(articulo.getLast_update_inventory());
      newArticulo.setCve_producto(articulo.getCve_producto());
      return new ResponseEntity<>(articuloServices.create(newArticulo), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @GetMapping(value = "/list")
  public ResponseEntity<List<Articulo>> getAllArticulos() {
    return ResponseEntity.ok(articuloServices.getAllArticulos());
  }

  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable(value = "id") Integer id) {
    articuloServices.delete(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Optional<Articulo>> getArticuloById(@PathVariable("id") Integer id) {
    return ResponseEntity.ok(articuloServices.findById(id));
  }
}
