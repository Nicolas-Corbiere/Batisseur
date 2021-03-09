package carte.cartesPresente;

import carte.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LesCartesPresentesMoyenAge.class, name = "LesCartesPresentesMoyenAge"),
        @JsonSubTypes.Type(value = LesCartesPresentesAntiquite.class, name = "LesCartesPresentesAntiquite"),
})

/**Classe abstraite qui permettra d'aceuillir des CartesPresente selon l'instanciation de ces classes fille
 * @see carte.cartesPresente.CartesPresente
 * @see carte.cartesPresente.LesCartesPresentesMoyenAge
 * @see carte.cartesPresente.LesCartesPresentesAntiquite
 */
public abstract class LesCartesPresentes
{
    /**
     * Constructeur LesCartesPresentes
     */
    public LesCartesPresentes() { }

    /**
     * Permet de retourner un objet CartesPresente avec son Typage de Carte.
     * @param classCarte parametre qui permettra d'indiquer le typage de carte d'un objet CartesPresente possède.
     * @param <T> Typage de Carte
     * @return Un Objet de la classe CartesPresente ou un null s'il ne trouve pas
     */
    public abstract <T extends Carte> CartesPresente<T> getCartesPresente(Class<T> classCarte);

    /**
     * Permet de prendre une carte d'une CartesPresente avec son Typage
     * @param classCarte parametre qui permettra d'indiquer le typage de carte d'un objet CartesPresente possède.
     * @param index index de la carte à prendre dans un objet de la classe CartesPresente
     * @param <T> Typage de Carte
     * @return Un Objet de la Classe Carte selon le typage de Carte demandé ou sinon un null s'il trouve pas la CartesPresente correspondante ou la Carte demandé
     */
    public abstract <T extends Carte> T prendreCarte(Class<T> classCarte, int index);
}
