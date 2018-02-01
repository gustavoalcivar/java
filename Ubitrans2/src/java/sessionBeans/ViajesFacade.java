/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBeans;

import entitys.Viajes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GUSTAVO
 */
@Stateless
public class ViajesFacade extends AbstractFacade<Viajes> {
    @PersistenceContext(unitName = "Ubitrans2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ViajesFacade() {
        super(Viajes.class);
    }
    
}
