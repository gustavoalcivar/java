/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBeans;

import entitys.UnidadRuta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GUSTAVO
 */
@Stateless
public class UnidadRutaFacade extends AbstractFacade<UnidadRuta> {
    @PersistenceContext(unitName = "Ubitrans2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadRutaFacade() {
        super(UnidadRuta.class);
    }
    
}
