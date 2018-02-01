/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBeans;

import entitys.ParadaRuta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GUSTAVO
 */
@Stateless
public class ParadaRutaFacade extends AbstractFacade<ParadaRuta> {
    @PersistenceContext(unitName = "Ubitrans2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParadaRutaFacade() {
        super(ParadaRuta.class);
    }
    
}
