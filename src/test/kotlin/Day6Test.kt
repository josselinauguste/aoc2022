import kotlin.test.Test
import kotlin.test.assertEquals

class Day6Test {
    @Test
    fun `How many characters need to be processed before the first start-of-packet marker is detected (sample)`() {
        val result = charsProcessedToGetStartOfPacket(sampleDatastreamBuffer)

        assertEquals(7, result)
    }

    @Test
    fun `How many characters need to be processed before the first start-of-packet marker is detected`() {
        val result = charsProcessedToGetStartOfPacket(datastreamBuffer)

        assertEquals(1651, result)
    }

    @Test
    fun `How many characters need to be processed before the first start-of-message marker is detected (sample)`() {
        val result = charsProcessedToGetStartOfMessage(sampleDatastreamBuffer)

        assertEquals(19, result)
    }

    @Test
    fun `How many characters need to be processed before the first start-of-message marker is detected`() {
        val result = charsProcessedToGetStartOfMessage(datastreamBuffer)

        assertEquals(3837, result)
    }

    private val sampleDatastreamBuffer = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
    private val datastreamBuffer =
        "rnttlvtttmnmpmhpmmzvmmhpmmnrntnnsnrnndvnddmbbtptssjcczmmbwmbmwwmmflfggwzzhjjgppwrwdwqwbbbmwbwgggqccmlmdmgdgqgpqgpgzzndddgdbbsvvfsfppwjwzjjcnjccwrwrprgppbpddnccjggfrggqngqgdqgddvsshqhmqqfvqvlvwvnwwmccrpcczvcczzgsgwwlggqsggmdgglblpblltbbzrbzzcscgccwssbddsmddzzvvhjjwjwrjwrwfftmttplldnllqttdhddmvdmmhsmsmqsqwqpqbpqppqdppbnpnhhppjbbrzrbrggdbddnrdrzrdrpdppzzfzrzgzllwlwzlllwtltslttlmtmqqbbzmzhmmjjwrjrrnzrzhzmmtbbrppmmfddjhdjdsdllrbbpfphpzpwwjvwwdpwpzwwzrrfnfwwfbbpttzjtjptpvvsfvvljjrzzmdmsddpvpgvvdcdwcwhwghwggrjjhdjhddzhhwbhwbwwbrwwrfrmfrfvrfftzzqrzqrqtrqtrqtrqttgctclcwlwwvqqnlnqlnnndmnmggznzhzqzggzrzbbrwbrwrvvscvvmvhmvvbsbjsjfjpfpqpbbbbjtjptpprnndpnnrsswffmnnjhhpqhqwhhbwhbhgbbfrbrjjpmjmzzdzjdjffcvvtwttrrcscvcncqcfcwwpgpfptpcpspllcfcssgbglgdllcdcmcpcqclctcvtvvbhbbdhhczhzshzhbhchzchchlcllwswqqmpmbbqwwzgzhggczgzffsgggjjlcjjpnjjfqjfjvfvrfrlrvvpfpcfcbffnmfmbmbgggplldblddvcvjcvvmbmmmrvrvvnhhqttgdgvdgdqgddcsclljplpbbsvbsbfsffshsgslsllzztggttfccctwtswwrvwvnnfbnnvjnvvlgvvfppmvpmmvpmmcttjffgsffcllncntcncfclcgcppvdvpvrvbrrnnvrvhrvrzvrvnrvrdrnrqrnngsshqhcqqbfqqzmmmzjzqztznttjffqzfqfbqqsggclgclcddtqqdppbjppqvpqvvmqmqnqcnqcqcqvqjqzqbzzbrrgfgddgtgnnpjjbzjjbbtstzszwswggfffmnnpllfvvnwnpwpqwqwlllqlmmzcmcrcmrcmrcrffnrnssjjrdjjwwqgwqgqdggwzwjzzbfbpptctchthbbbqsqggrllldwdffvwwlrwwljwjnncmmjmvjmmqnnmrrgjgvvpqqbppqlpqllqnqdndwwlppcjcdjjcnnmddffgjjrwjrwjjhvhqvhhfssrtsrsgrrwjwhhbqqpzzrdrhrqhrqrprqqmllsszhzllcdllpmpbbmsmjjmwmssvlslwwmtwmmgvgcvggzcgzgddsjsjfsssftfcchhfmfcmcpcpvcppqggjddljjbttwrrhghqggpghgngzngznnzqnnssqlqmqbmmmqdqqhttnqqjhhphrhccbggmjjpwpbwpprdrvvjzvvtctzzmpphwpwdpdvvhbvvdvsdsjdjbdjdljjstswttnhhbfffmnngddlglqggvzvlzvzqqvbqbvbjbnjjsvjjwpjjzshrdtrjttvqnbltrfpvnztrwzrtgjpzgqdjfglqgjrgdzbhqpghdbfhlfjhbfjfjppfgljmgwljlsbmltgztthnzvdrgqlgddvqhzctdgcphfqvnpjjgzwqfvnhvzdrwtpgfdjpqnfshslqmplcprdntnhqqbqptwzvdddhcjcqrfhjqnjvpnhttblwgjwlfwntdchgfjmdbgtqtdgnzbqwzzcltwtmtqtdbvjtfvlzpcvgmrfqwfhwqmhvwhftzgmhshffnjwqbvztszsrrglqvhfpqmbnqjsfnwdwgdtmztbvqrmztfctmvptbwnfzfgdztjgnqsrsqqqnrpgzsqszzwwwgqnnnrdzhzdbqjgbvncprzcjqchzfgnclbrmphbsdwwpvwjwlbshhgjfbhjjtdqrmrcjfnrrhqrpsbglthzpvfglqspttdpwlljhnlrjpzchbrqcgtmcscjnwvpztfjdcwbnbgmbpgdthgnhbrtwftnscbsrndghbslflpcpjwbcjnhzcwdcslmzqbtrlnzmntlpjcsctnsqwtbffqlhfgcsflvfwnmczvsbflnnnzpfjfrcwhhcbtbjcbghtcwcgdbrwrgfgvpwtcwlwcmnmrtcrjbwtwlrfstztsghfvrfjzzpswpqfqpvqstvbhqfjlgmtdlhqrhwzqpnqpllnlgzwptbgftmblqcwfcllbwfzdhrndfrvdvwzqvhnghlzvhldnnvrgqvlpfdnpmcgddjmstzsqfvzwftflrwtzqwjbbqhjpfbdztdfsgsztvvrvslgspgpdcmwszdfsddqhpzpsjgqmgzqvhchlgrmcmzwzbtwfphvgcdmhfdczhffgmqpncdjszzgwfvwsqddvbcgngbjwhmphjsmjthvbthhfwdtqmjctcmdpqpsdrnrzdgzgzctbhwsgvtjgwjbsnnjmpmqgwrnqfqbpnrpddjsrsvmcshhthwfrwmqsrjhlsrgfzvwmdzhwrvchppqldghgzflrnwqnvntmtdwmrpgbdbzvcmnqstzntvllcgzsnvrhqzsfncznhgrggmvrmgsqmhbdsjbsqqhzppfcwdrgdvfjdscrvpwtsdmcnczwbbjhvddprwtzfwslcfdcrqfszcgmhtdfvlqzqtvwngzvmmqcrqpzwzhggjnphsrmnctnfhtppglspnvzrsqfgzdfrrwbzbqwvbvbnzgmdrqrnsvdpvlgcmnggsbmbtfwrvdjrtgtgcqscnfpgswgsngdqnnscffdcnlrcpdpcbpzvqcrtjhlwvgnfhhqmprthrtcvcjjwgprqqdwfbgmzlwttjpvcjzfwbdhvngsjpgtqsvbldbcvhjhzbjzblqtqhlnbzzqfcpnzdhbplztcgvzhbgshqbccgwzhftqvtwzbwmnfrsgphhhgtsmwlqhlcchtbtggqwmbdthhmqqjtfdvfpddfdrtfjbpmwtcbfnrhwcnpdqrdtsfdmjfzdwwgnftnwpssgqtlpdbwhnzcnfmppclsswbhcdghpnslwjznqszgdtrnpncsqsnbrplrfwpbnfnvttlzcjtvhzcpzmhfsfzfjlzqqnprpdvwbfthmrswqrcqqwrnwzmgjqqsnqdblssmhngjjvprmqbswtgzzvprwhrgjqshvmwzgrgfmzlgrtzbmdlzncwqdftfsndvdfmmplswdbjtbcbvcvtpjvrqpghczpqvvpqwfbfhllbpvrrfsmsjhqbldcrwvzvcvzfffqvplbfbdbwctbjsljlfwtbcnpsbtpmcqgdvltmztvrcfsprbnvwplwhncgsdnrdmqnmcvpvvrlmlwtgvrnwvzsfctdlcfvtgqmpnbwcbwvfpmqnbjvwffpjtvvgflhrnlngrzhhttdtdbvscftsqtvbrgzfgsjvwhzjcbsqcttlgwmhhvjhwhgmmdtflfdbvnhgcblqmwjfsqnngjqfbvdnsfbgwjfhpgdgvhpbvlrtpcpvhrbtqpbffzcqrvbqwvqmmrcwtnvcgwvsqzvrwdbcnjshbnbftmmvrmjvgfdwbsjvqfdwnnvqqhbmshcrclrwhfhbtnwqvmrrvdwgcwcsrhdbqndsthmrmbjhttjtzmlflbrmhlcgsbdjcjcvwcjffnqrntpflrgfcngpchtrzpnflwjvcgbwtsnjfqsggwmwhdvbzdpjmtwlmrslnjsndjtgjmmwmdgtnfrztppzqvqhbfzqpsdhvsshddlzwcmsndrpqhndsrjnngnmgmzrvchwlqgdnbssbhpbpgwpsrcnbphpslvqplhpgdhmrnwwjmhvnsfjmrfwtvjjrmgptvjffhbgpmfgmgrcjrwqhccssrqjpljbpwcvsfdtmbhzsmsjsgblgpcqszsttfclrjcnsslmngmbmwqfhddbvmbvwmrmvglsl"
}